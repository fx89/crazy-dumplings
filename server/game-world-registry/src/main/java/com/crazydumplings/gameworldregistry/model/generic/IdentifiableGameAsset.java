package com.crazydumplings.gameworldregistry.model.generic;

import java.io.Serializable;

/**
 * The Identifiable interface may be found in many APIs (e.g. Oracle Fusion, Sap BI, Apache Spark).
 * <br /><br />
 * In this case, it ensures that all interfaces within the game world registry specification will
 * be identifiable via an identifier of type Long. This contract is helpful for generic methods
 * such as {@link com.crazydumplings.gameworldregistry.GameWorldRegistryService#splitAssetsList}.
 * <br /><br />
 * Identifiable game assets are also serializable as they are transmitted over various mediums
 */
public interface IdentifiableGameAsset extends Serializable {
	Long getId();
}
