package com.punishment.conversion;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.util.HashMap;
import java.util.Map;

public class StringDoubleConverter implements Converter<Double> {
    private static final Map<String, Double> javaMap = new HashMap<>();
    private static final Map<Double,String> excelMap = new HashMap<>();
    static {
        javaMap.put("正常", 0.0);
        javaMap.put("通报批评", 0.5);
        javaMap.put("警告", 1.0);
        javaMap.put("严重警告", 2.0);
        javaMap.put("记过", 3.0);
        javaMap.put("留校察看", 4.0);

        excelMap.put(0.0,"正常");
        excelMap.put(0.5,"通报批评");
        excelMap.put(1.0,"警告");
        excelMap.put(2.0,"严重警告");
        excelMap.put(3.0,"记过");
        excelMap.put(4.0,"留校察看");
    }

    @Override
    public Double convertToJavaData(ReadCellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        String data = String.valueOf(cellData.getStringValue());
        return javaMap.get(data);
    }

    @Override
    public Double convertToJavaData(ReadConverterContext context) {
        String data = String.valueOf(context.getReadCellData().getStringValue());
        return javaMap.get(data);
    }

    @Override
    public WriteCellData<?> convertToExcelData(Double value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) {
        String data = excelMap.get(Math.floor(value));
        return new WriteCellData<>(data);
    }

    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<Double> context) {
        String data = excelMap.get(Math.floor(context.getValue()));
        return new WriteCellData<>(data);
    }
}
