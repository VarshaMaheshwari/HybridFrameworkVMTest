package utils;

import java.io.*;
import java.util.zip.GZIPInputStream;

public class ByteArrayConverterUtil {
    public static String byteArrayConverter(SampleResponse sampleResponse) throws IOException {

        ByteArrayInputStream bais = new ByteArrayInputStream(sampleResponse.getResponse());
        GZIPInputStream gzipIn = new GZIPInputStream(bais);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gzipIn));
        StringWriter stringWriter = new StringWriter();
        String readLine;
        while ((readLine = bufferedReader.readLine()) != null) {
            stringWriter.write(readLine);
        }
        return stringWriter.toString();
    }

}
