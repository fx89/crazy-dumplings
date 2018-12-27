package com.crazydumplings.gameworldregistry.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.crazydumplings.gameworldregistry.GameWorldRegistryService;
import com.crazydumplings.gameworldregistry.exception.MissingSerializerDeserializerException;
import com.crazydumplings.gameworldregistry.model.GameClientType;
import com.crazydumplings.gameworldregistry.model.GameObjectTypeRepresentation;

/**
 * Handles the serialization and deserialization operations for the {@link GameWorldRegistryService}
 */
public class GameWorldRegistrySerializationHelper {
    /**
     * Inject custom serializers/de-serializers here. THERE ARE NO DEFAULT SERIALIZERS/DE-SERIALIZERS.
     */
    private List<SpriteStateVisualRepresentationSerializerDeserializer> visRepSerializersDeserializers = new ArrayList<>();

    /**
     * Finds a custom made serializer for the given object type and performs the serialization. Throws an exception in case no serializer could
     * be identified.
     */
    public String hashSpriteStateVisualRepresentation(GameClientType gameClientType, Object visualRep)
            throws MissingSerializerDeserializerException {
        if (visualRep == null)
            throw new IllegalArgumentException("The provided visual representation reference is null");

        SpriteStateVisualRepresentationSerializerDeserializer serializer = visRepSerializersDeserializers.stream()
                .filter(sd -> sd.isManageableRepresentationType(gameClientType.getUniqueName())).findFirst()
                .orElseThrow(() -> new MissingSerializerDeserializerException(
                        "The service has not know how to serialize objects of type [" + visualRep.getClass().getCanonicalName() + "]"));

        return serializer.serialize(visualRep);
    }

    /**
     * Finds a custom made deserializer for the data contained by the referenced visual representation and uses it to create a visual
     * representation.
     */
    public Object fromSpriteStateVisualRepresentation(GameObjectTypeRepresentation visRep) throws MissingSerializerDeserializerException {
        Objects.requireNonNull(visRep, "The provided serialized visual representation reference is null");
        Objects.requireNonNull(visRep.getObjectHash(), "The referenced object has an empty hash");
        Objects.requireNonNull(visRep.getGameClientType(), "No game client type specified for the referenced object");

        Objects.requireNonNull(visRep.getGameClientType().getUniqueName(),
                "The client type specified for the referenced object does not have a name");

        SpriteStateVisualRepresentationSerializerDeserializer deserializer = visRepSerializersDeserializers.stream()
                .filter(sd -> sd.isManageableRepresentationType(visRep.getGameClientType().getUniqueName())).findFirst()
                .orElseThrow(() -> new MissingSerializerDeserializerException(
                        "The service has not know how to deserialize the object named [" + visRep.getGameClientType().getUniqueName() + "]"));

        return deserializer.deserialize(visRep.getObjectHash());
    }

    public List<SpriteStateVisualRepresentationSerializerDeserializer> getVisRepSerializersDeserializers() {
        return visRepSerializersDeserializers;
    }

    public void setVisRepSerializersDeserializers(List<SpriteStateVisualRepresentationSerializerDeserializer> visRepSerializersDeserializers) {
        this.visRepSerializersDeserializers = visRepSerializersDeserializers;
    }

    public void addVisRepSerializersDeserializer(SpriteStateVisualRepresentationSerializerDeserializer visRepSD) {
        visRepSerializersDeserializers.add(visRepSD);
    }

}
