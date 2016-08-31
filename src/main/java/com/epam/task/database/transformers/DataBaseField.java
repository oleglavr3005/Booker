package com.epam.task.database.transformers;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})

public @interface DataBaseField {

	/**
	 * fiend name in the DB
	 */
	public String fieldName();
}
