/*
 * DataConverter
 * converting from xml to json and vice versa
 *
 * OpenAPI spec version: 1.00
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets Type
 */
public enum Type {
  JSON("json"),
    XML("xml");

  private String value;

  Type(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Type fromValue(String text) {
    for (Type b : Type.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}
