package dong.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jayway.jsonpath.spi.json.JsonOrgJsonProvider;

import java.io.*;
import java.util.Iterator;

/**
 * @CopyRightBy zcy.qyg.cn
 * @Author DongQing
 * @Date 2019-06-11 17:35
 * @ClassName readMapData
 * @Description TODO
 **/
public class readMapData {
    public static void main(String[] args){
        String mapData = "{\"code\":0,\"message\":\"没有查询到数据\",\"data\":null,\"taskId\":\"0-bb03193f-ed1f-4d32-8351-6538d329b26e\",\"time\":\"2017-09-2210:11:30\"}";

        Object o = JSONObject.toJSON(mapData);
        JSONObject jsonObject = JSONObject.parseObject(mapData);
        jsonObject.getString("message");


        String filename = "./zhijiang.txt";
        File file = new File(filename);
        BufferedReader reader = null;
        StringBuilder sBuilder = new StringBuilder();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;

            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                sBuilder.append(tempString);
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }

        String template = sBuilder.toString();

        StringBuilder map = new StringBuilder();

        JSONObject object =  JSONObject.parseObject(template).getJSONObject("route");
        JSONArray jsonArray = (JSONArray)object.getJSONArray("paths").getJSONObject(0).getJSONArray("steps");
        System.out.println("***********************");

        for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {

            JSONObject object1 =  JSONObject.parseObject(iterator.next().toString());
            map.append(object1.getString("polyline")).append(";");
            System.out.println(object1.getString("polyline"));
        }

        String[] mapArray = map.toString().split(";");
        StringBuilder mapFormule = new StringBuilder();

        if(mapArray.length>0){
            mapFormule.append("[[")
                    .append(mapArray[0])
                    .append("]");

            for(int i = 1; i<mapArray.length;i++){
                mapFormule.append(",[")
                        .append(mapArray[i])
                        .append("]");
            }
            mapFormule.append("]");
        }
        System.out.println("#####################");
        System.out.println(mapFormule.toString());





    }

}
