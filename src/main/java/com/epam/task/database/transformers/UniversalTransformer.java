package com.epam.task.database.transformers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UniversalTransformer {
	//public static final Logger LOG = Logger.getLogger(UniversalTransformer.class);

	public static <T> List<T> getCollectionFromRS(ResultSet result, Class<T> clazz) throws SQLException {

		List<T> collection = new ArrayList<T>();

		while (result.next()) {
			collection.add(getCurrentRow(result, clazz));
		}

		return collection;
	}

	public static <T> T getObjectFromRS(ResultSet result, Class<T> clazz) throws SQLException {

		if (result.next()) {
			return getCurrentRow(result, clazz);
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getCurrentRow(ResultSet result, Class<T> clazz) throws SQLException {

		Field[] fields = clazz.getDeclaredFields();

		Constructor<T>[] constructors = (Constructor<T>[]) clazz.getDeclaredConstructors();

		Constructor<T> constructor = constructors[0];

		List<Object> values = new ArrayList<Object>();
		for (Field field : fields) {
			DataBaseField anotation = field.getAnnotation(DataBaseField.class);
			if (anotation != null) {
				String fieldName = anotation.fieldName();
				Class<?> fieldType = field.getType();
				values.add(getValue(fieldName, fieldType, result));
			}
		}

			try {
				return constructor.newInstance(values.toArray());
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				//LOG.error("Something is wrong with the transformer", e);
				return null;
			}
	}

	private static Object getValue(String fieldName, Class<?> fieldType, ResultSet result) throws SQLException {
		if (fieldType == String.class) {
			return result.getString(fieldName);
		}
		if (fieldType == Timestamp.class) {
			return result.getTimestamp(fieldName);
		}
		if (fieldType == int.class) {
			return result.getInt(fieldName);
		}
		if (fieldType == double.class) {
			return result.getDouble(fieldName);
		}
		if (fieldType == boolean.class) {
			return result.getBoolean(fieldName);
		}
		return null;
	}
}

