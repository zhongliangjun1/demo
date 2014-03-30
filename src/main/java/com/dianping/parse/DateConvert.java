package com.dianping.parse;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-30
 * Time: PM4:58
 * To change this template use File | Settings | File Templates.
 */
public class DateConvert implements Converter {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void marshal(Object o, HierarchicalStreamWriter hierarchicalStreamWriter, MarshallingContext marshallingContext) {

        String value = sdf.format(o);
        hierarchicalStreamWriter.setValue(value);
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader hierarchicalStreamReader, UnmarshallingContext unmarshallingContext) {
        String value = hierarchicalStreamReader.getValue();
        Date date = null;
        try {
            date = sdf.parse(value);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return Date.class.isAssignableFrom(aClass);
    }
}
