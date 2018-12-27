package com.crazydumplings.gameworldregistry.helper;

import com.crazydumplings.gameworldregistry.GameWorldRegistryService;

/**
 * Allows specifying custom serialization and de-serialization algorithms to be used when storing and loading
 * {@link com.crazydumplings.gameworldregistry.model.sprites.SpriteStateVisualRepresentation visual representations}. In theory,
 * custom-serialized data will be shorter than what comes out of Java Serialization since the object-specific encoding does not need to provide
 * data type identifiers and property names. Means of identifying the data type of the object to be serialized, as well as that of the object to
 * be de-serialized are also provided here. Multiple instances of this class can be injected into the {@link GameWorldRegistryService} service to allow
 * automatic conversion.
 */
public interface SpriteStateVisualRepresentationSerializerDeserializer {
    /**
     * Serialization method which should also provide an identification sequence for the object to be serialized
     */
    String serialize(Object visualRepresentation);

    /**
     * De-serialization method
     */
    Object deserialize(String serializedVisualRepresentation);

    /**
     * Queried by the {@linked GameWorldRegistry} while trying to find a serializer for the given object type.
     */
    boolean isManageableRepresentationType(Object representation);

    /**
     * Queried by the {@link GameWorldRegistryService} while trying to identify the type of object to which to de-serialzier the given string
     */
    boolean isManageableRepresentationType(String serializedRepresentation);
}
