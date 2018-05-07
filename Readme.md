# **Guideline**

## **Module**

> workflow-demo The main module used to load jar

> kn-module-demo The jar module used to execute the approval logic for Kn product

> wps-module-demo The jar module used to execute the approval logic for wps product

***

## **How to use**

1.Package the module demo to the lib forder in workflow-demo and run the Main class.

**For example:**

I want to use the kn-module-demo and wps-module-demo.

Step:

- Create a forlder named "process" in root of "D" disk and copy the workflow tempalte
to "process" in "D" disk from the "process" folder in project.

![avatar](docs/微信截图_20180507080710.png)

![avatar](docs/微信截图_20180507080815.png)

- Use "mvn package" command to generate the jar and rename to
"kn-moudule-demo-0.0.1.jar" or "wps-module-demo-0.0.1.jar"

![avatar](docs/微信截图_20180507073544.png)
![avatar](docs/微信截图_20180507073628.png)

- Copy JARS to lib forder in "workflow-demo"

![avatar](docs/微信截图_20180507073229.png)

- Run "WorkflowDemoApplication" in workflow-demo

- Input the URL "localhost:8080/uflo/central" in browser and request,you'll see
bellow workflow consol.

![avatar](docs/微信截图_20180507074405.png)

- Run the worflow template by "Run" button ![avatar](docs/微信截图_20180507074553.png) and
input the parameters as flowing:

![avatar](docs/微信截图_20180507075544.png)

- Click "Run" button ![avatar](docs/微信截图_20180507074942.png) to request

- You can see the execution log showed in the console

![avatar](docs/微信截图_20180506172139.png)

***

## WORKING PRINCIPLE

![avatar](docs/A产品审核流程.png)

![avatar](docs/B产品审核流程.png)
