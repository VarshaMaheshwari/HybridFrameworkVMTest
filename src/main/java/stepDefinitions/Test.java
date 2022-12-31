package stepDefinitions;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

public class Test {
    
    if (StringUtils.isNotEmpty(dto.getCustomObject())) {
        if (dto.getCustomObject().equalsIgnoreCase("exists")) {
            List<HashMap<String, Object>> resCustomObject = response.jsonPath().get("CustomObject");
            for (int j = 0; j < resCustomObject.size(); j++) {
                String resDataUid = resCustomObject.get(j).get("DataUid").toString();
                Assert.assertNotNull(resDataUid);
                String resDataType = resCustomObject.get(j).get("DataType").toString();
                Assert.assertNotNull(resDataType);

            }
        }

    }

    if (StringUtils.isNotEmpty(dto.getSourceId())) {
        for (int j = 0; j < dto.getCustomObjeTypeList().size(); j++) {
            List<Integer> sourceIdList = response.jsonPath()
                    .get("CustomObjeTypedata" + dto.getCustomObjeTypeList().get(j) + ".sourceIds");

            List<String> expSourceList = new ArrayList<String>();

            for (int m = 0; m < dto.getsourceIdList().get(j).size(); m++) {
                expSourceList = Arrays.asList(dto.getsourceIdList().get(j).get(m).split("\\s*,\\s*"));
            }
            Assert.assertEquals(expSourceList.toString(), sourceIdList.toString());
        }
    }

    JsonArray jsonArray = new JsonArray();
        System.out.println("Response-->" + response.asString());
    jsonArray = new Gson().fromJson(response.asString(), JsonArray.class);
        Assert.assertTrue(jsonArray.size() != 0, "Test version details are not present");
        if (StringUtils.isNoneEmpty(dto.getHttpStatusCode())) {
        Assert.assertEquals(Integer.valueOf(response.getStatusCode()).toString(), dto.getHttpStatusCode());
    }
        for (int i = 0; i < jsonArray.size(); i++) {
        JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();


            if (StringUtils.isNotEmpty(dto.getCurrentValue().toString())) {
                Assert.assertEquals(jsonObject.get("current").getAsString(), (dto.getCurrentValue().toString()));
            }

            if (StringUtils.isNotEmpty(dto.getDeletableValue().toString())) {
                Assert.assertEquals(jsonObject.get("deletable").getAsString(),
                        (dto.getDeletableValue().toString()));
            }
            break;
        }
    }

}
