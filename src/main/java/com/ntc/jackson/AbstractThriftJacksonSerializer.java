/*
 * Copyright 2015 nghiatc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ntc.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Collection;
import org.apache.thrift.TBase;
import org.apache.thrift.TFieldIdEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nghiatc
 * @since Sep 11, 2015
 * 
 * This abstract class represents a generic serializer for converting Thrift-based entities to JSON.
 * 
 * @param <E> An implementation of the {@link TFieldIdEnum} interface.
 * @param <T> An implementation of the {@link TBase} interface.
 */
public abstract class AbstractThriftJacksonSerializer <E extends TFieldIdEnum, T extends TBase<T, E>> extends JsonSerializer<T> {

    private static final Logger log = LoggerFactory.getLogger(AbstractThriftJacksonSerializer.class);

    @Override
    public Class<T> handledType() {
        return getThriftClass();
    }

    @Override
    public void serialize(final T value, final JsonGenerator jgen, final SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        for(final E field : getFieldValues()) {
            if(value.isSet(field)) {
                final Object fieldValue = value.getFieldValue(field);
                if(fieldValue != null) {
                    log.info("Adding field '{}' to the JSON string...", field.getFieldName());
                    jgen.writeFieldName(field.getFieldName());
                    if(fieldValue instanceof Short) {
                        jgen.writeNumber((Short)fieldValue);
                    } else if(fieldValue instanceof Integer) {
                        jgen.writeNumber((Integer)fieldValue);
                    } else if(fieldValue instanceof Long) {
                        jgen.writeNumber((Long)fieldValue);
                    } else if(fieldValue instanceof Double) {
                        jgen.writeNumber((Double)fieldValue);
                    } else if(fieldValue instanceof Float) {
                        jgen.writeNumber((Float)fieldValue);
                    } else if(fieldValue instanceof Boolean) {
                        jgen.writeBoolean((Boolean)fieldValue);
                    } else if(fieldValue instanceof String) {
                        jgen.writeString(fieldValue.toString());
                    } else if(fieldValue instanceof Collection) {
                        log.info("Array opened for field '{}'.", field.getFieldName());
                        jgen.writeStartArray();
                        for(final Object arrayObject : (Collection<?>)fieldValue) {
                            jgen.writeObject(arrayObject);
                        }
                        jgen.writeEndArray();
                        log.info("Array closed for field '{}'.", field.getFieldName());
                    } else {
                        jgen.writeObject(fieldValue);
                    }
                } else {
                    log.info("Skipping converting field '{}' to JSON:  value is null!", field.getFieldName());
                }
            } else {
                log.info("Skipping converting field '{}' to JSON:  field has not been set!", field.getFieldName());
            }
        }
        jgen.writeEndObject();
    }

    /**
     * Returns an array of {@code <E>} enumerated values that represent the fields present in the
     * Thrift class associated with this serializer.
     * @return The array of {@code <E>} enumerated values that represent the fields present in the
     *   Thrift class.
     */
    protected abstract E[] getFieldValues();

    /**
     * Returns the {@code <T>} implementation class associated with this serializer.
     * @return The {@code <T>} implementation class
     */
    protected abstract Class<T> getThriftClass();
    
}
