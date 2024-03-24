package com.punishment.conversion;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.util.HashMap;
import java.util.Map;

public class StringDoubleConverter implements Converter<Double> {
    private static final Map<String, Double> map = new HashMap<>();
    static {
        map.put("正常", 0.0);
        map.put("通报批评", 0.5);
        map.put("警告", 1.0);
        map.put("严重警告", 2.0);
        map.put("记过", 3.0);
        map.put("留校察看", 4.0);
    }

    @Override
    public Double convertToJavaData(ReadCellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        String data = String.valueOf(cellData.getStringValue());
        return map.get(data);
    }

    @Override
    public Double convertToJavaData(ReadConverterContext context) {
        String data = String.valueOf(context.getReadCellData().getStringValue());
        return map.get(data);
    }

}
