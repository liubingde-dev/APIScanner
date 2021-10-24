package com.lbd.analyst.model.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对象类型
 */
public class ObjectType implements Type {
    private Map<String, Type> filedMap =new HashMap<>();

    public Map<String, Type> getFiledMap() {
        return filedMap;
    }

    public void setFiledMap(Map<String, Type> filedMap) {
        this.filedMap = filedMap;
    }

    public void addField(String fieldName,Type field){
        filedMap.put(fieldName,field);
    }

    @Override
    public String getDefaultValue() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        List<String> filedList = new ArrayList<>(filedMap.keySet());

        for (int i = 0; i < filedList.size(); i++) {
            String filedName = filedList.get(i);
            Type filed = filedMap.get(filedName);
            stringBuilder.append("\"");
            stringBuilder.append(filedName);
            stringBuilder.append("\"");
            stringBuilder.append(":");
            stringBuilder.append(filed.getDefaultValue());
            if (i != filedList.size() - 1) {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
