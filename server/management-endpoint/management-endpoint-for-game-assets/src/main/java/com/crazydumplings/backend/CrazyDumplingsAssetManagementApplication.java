package com.crazydumplings.backend;

import com.crazydumplings.gameworldregistry.GameWorldRegistryDataService;
import com.crazydumplings.gameworldregistry.GameWorldRegistrySecurityService;
import com.crazydumplings.gameworldregistry.GameWorldRegistryService;

public class CrazyDumplingsAssetManagementApplication {
    public static void main(String[] args) {
        CrazyDumplingsWebApplication.main(args, (applicationContext -> {
            GameWorldRegistryDataService dataService
                = (GameWorldRegistryDataService) applicationContext.getBean(
                                                            applicationContext.getEnvironment().getProperty("crazydumplings.gameworldregistry.dataservice")
                                                       );

            applicationContext.getBean(GameWorldRegistryService.class        ).setDataService(dataService);
            applicationContext.getBean(GameWorldRegistrySecurityService.class).setDataService(dataService);
        }));
    }
}
