Proxy Server
==

Welcome to the Proxy Server Repository. <br>
This repository contains the source code, documentation, and related resources for the Proxy Server.

## S/W Specifications
| Category           | Details                                         |
|--------------------|-------------------------------------------------|
| OS                 | macOS / Linux / Windows 10 or higher            |
| Language           | Java 21 or higher                               |
| IDE                | IntelliJ IDEA                                   |
| Build System       | Gradle 8.8 or higher                            |
| Compatibility      | Requires JDK 21 or higher                       |
| Docker             | Docker and Docker Compose must be installed     |
| Other Requirements | Minimum 2GB RAM and 10GB of disk space required |

## Folder Structure
Overview of the major folders and documents in the project directory:

```
did-proxy-server
├── CHANGELOG.md
├── CLA.md
├── CODE_OF_CONDUCT.md
├── CONTRIBUTING.md
├── LICENSE
├── dependencies-license.md
├── MAINTAINERS.md
├── README.md
├── RELEASE-PROCESS.md
├── SECURITY.md
├── docs
│   └── api
│       ├── Proxy_API.md
│       └── Proxy_API_ko.md
│   └── errorCode
│       └── Proxy_ErrorCode.md
└── source
    └── did-proxy-server
        ├── gradle
        ├── libs
        ├── src
        ├── build.gradle
        └── README.md
```

<br/>

Below is a description of each folder and file in the directory:

| Name                             | Description                                     |
| -------------------------------- | ----------------------------------------------- |
| CHANGELOG.md                     | Version-specific changes in the project         |
| CODE_OF_CONDUCT.md               | Code of conduct for contributors                |
| CONTRIBUTING.md                  | Contribution guidelines and procedures          |
| LICENSE                          | License                                         |
| dependencies-license.md          | Licenses for the project’s dependency libraries |
| MAINTAINERS.md                   | Guidelines for project maintainers              |
| RELEASE-PROCESS.md               | Procedures for releasing new versions           |
| SECURITY.md                      | Security policies and vulnerability reporting   |
| docs                             | Documentation                                   |
| ┖ api                            | API guide documentation                         |
| ┖ errorCode                      | Error codes and troubleshooting guides          |
| source                           | Server source code project                      |
| ┖ did-proxy-server               | Proxy Server source code and build files    |
| &nbsp;&nbsp;&nbsp;┖ gradle       | Gradle build configurations and scripts         |
| &nbsp;&nbsp;&nbsp;┖ libs         | External libraries and dependencies             |
| &nbsp;&nbsp;&nbsp;┖ src          | Main source code directory                      |
| &nbsp;&nbsp;&nbsp;┖ build.gradle | Gradle build configuration file                 |
| &nbsp;&nbsp;&nbsp;┖ README.md    | Overview and instructions for the source code   |

<br/>


## Libraries

Libraries used in this project are managed via the [build.gradle](source/did-proxy-server/build.gradle) file.


## API Reference

- **Proxy API**: Detailed reference for the Proxy Server's API endpoints and usage.
  - [Proxy API Reference](docs/api/Proxy_API.md)

## Change Log

The Change Log provides a detailed record of version-specific changes and updates. You can find it here:
- [Change Log](./CHANGELOG.md)

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) and [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md) for details on our code of conduct, and the process for submitting pull requests to us.

## License
[Apache 2.0](LICENSE)
