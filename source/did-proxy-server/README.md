# Proxy Server Source Code

Welcome to the Proxy Server source code repository. This directory contains the core source code and build configurations for the Proxy Server.

## Directory Structure

Here's an overview of the directory structure.

```
did-proxy-server
├── gradle
├── libs
├── src
├── build.gradle
├── README.md
└── README_ko.md
```

<br/>

Below is a description of each folder and file in the directory:

| Name                    | Description                                     |
| ----------------------- | ----------------------------------------------- |
| did-proxy-server        | Proxy Server source code and build files    |
| ┖ gradle                | Gradle build configurations and scripts         |
| ┖ libs                  | External libraries and dependencies             |
| ┖ src                   | Main source code directory                      |
| ┖ build.gradle          | Gradle build configuration file                 |
| ┖ README.md             | Overview and instructions for the source code   |


## Libraries

Libraries used in this project are managed via the [build.gradle](build.gradle) file.

1. **Third-Party Libraries**: These libraries are open-source dependencies managed via Gradle. For a detailed list of third-party libraries and their licenses, please refer to the [dependencies-license.md](../../dependencies-license.md) file.

2. **Local Libraries**: Any additional JAR files should be placed in the [libs folder](libs).


## Documentation

Refer to the following documents for more detailed information:

- [Proxy API](../../docs/api/Proxy_API.md)  
  Guide for the Proxy Server's API.

## Contributing

Please read [CONTRIBUTING.md](../../CONTRIBUTING.md) and [CODE_OF_CONDUCT.md](../../CODE_OF_CONDUCT.md) for details on our code of conduct, and the process for submitting pull requests to us.

## License
[Apache 2.0](../../LICENSE)

## Contact
For questions or support, please contact [maintainers](../../MAINTAINERS.md).
