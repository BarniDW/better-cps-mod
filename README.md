How to implement the mod?
  1) Create a class named:
  ModCPS
  2) Create a field in ModInstances: 	
  private static ModCPS modCPS;
  3) Call it in ModInstances:
  modCPS = new ModCPS();
  api.register(modCPS);
