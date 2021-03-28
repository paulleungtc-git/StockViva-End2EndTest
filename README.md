
### Set up
Selenium Grid Server set up on another Macbook and registered an Android VM node onto it on the same Macbook.

Code and execution from different Macbook.

Selenium Server set up
```shell
java -jar selenium-server-standalone-3.141.5.jar -role hub
```

Node set up
```shell
appium --nodeconfig nodeConfig.json
```

Node Config
```json
{
  "capabilities":
      [
        {
          "browserName": "Android Emulator",
          "deviceName": "Android Emulator",
          "version": "AOS 10.0",
          "udid": "emulator-5554",
          "platformName": "Android",
          "platformVersion": "10.0"
        }
      ],
  "configuration":
  {
    "cleanUpCycle":2000,
    "timeout":30000,
    "proxy": "org.openqa.grid.selenium.proxy.DefaultRemoteProxy",
    "url":"http://localhost:4723/wd/hub",
    "host": "localhost",
    "port": 4723,
    "maxSession": 5,
    "register": true,
    "registerCycle": 5000,
    "hubPort": 4444,
    "hubHost": "localhost",
    "hubProtocol": "http"
  }
}
```

### Framework
Using Page Object Model for this project.It helps to provide a reusable and managable way onto the test code.



