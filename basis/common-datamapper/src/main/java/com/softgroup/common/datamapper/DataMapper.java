package com.softgroup.common.datamapper;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.InputStream;
import java.util.Map;

/**
 * @author vlischyshyn
 */
public interface DataMapper {

	<K, V> Map<K, V>  convertToMap(Object value);

	<T> T convert(Map<String, Object> map, Class<T> dataType);

	<F, T> T convert(F from, TypeReference<T> dataType);

	<T> T convert(Object from, Class<T> dataType);

	<T> T mapData(String data, Class<T> dataType);

	<T> T mapData(String data, TypeReference dataType);

	<T> T mapData(byte[] message, Class<T> dataType);

	<T> T readValue(InputStream src, Class<T> valueType);

	<T> String dataToString(T data);

	String objectToString(Object data);

    TypeFactory getTypeFactory();

	<T> T mapData(String request, JavaType javaType);
}
