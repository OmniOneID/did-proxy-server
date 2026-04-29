# Proxy 서버 소스 코드

Proxy 서버 소스 코드 저장소에 오신 것을 환영합니다. 이 디렉토리는 Proxy 서버의 핵심 소스 코드와 빌드 설정을 포함하고 있습니다.

## 디렉토리 구조

디렉토리 구조에 대한 개요는 다음과 같습니다.

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

디렉토리 내의 각 폴더 및 파일에 대한 설명은 다음과 같습니다:

| 이름                    | 설명                                            |
| ----------------------- | ----------------------------------------------- |
| did-proxy-server        | Proxy 서버 소스 코드 및 빌드 파일              |
| ┖ gradle                | Gradle 빌드 설정 및 스크립트                    |
| ┖ libs                  | 외부 라이브러리 및 종속성                       |
| ┖ src                   | 메인 소스 코드 디렉토리                         |
| ┖ build.gradle          | Gradle 빌드 설정 파일                           |
| ┖ README.md             | 소스 코드 개요 및 안내                          |


## 라이브러리

이 프로젝트에서 사용되는 라이브러리는 [build.gradle](build.gradle) 파일을 통해 관리됩니다.

1. **외부 라이브러리 (Third-Party Libraries)**: Gradle을 통해 관리되는 오픈 소스 종속성입니다. 외부 라이브러리 및 해당 라이선스의 상세 목록은 [dependencies-license.md](../../dependencies-license.md) 파일을 참조하십시오.

2. **로컬 라이브러리 (Local Libraries)**: 추가적인 JAR 파일은 [libs 폴더](libs)에 위치해야 합니다.


## 문서

더 자세한 정보는 다음 문서를 참조하십시오:

- [Proxy API](../../docs/api/Proxy_API_ko.md)  
  Proxy 서버 API 가이드.

## 기여하기

코드 규약 및 풀 리퀘스트(Pull Request) 제출 프로세스에 대한 자세한 내용은 [CONTRIBUTING.md](../../CONTRIBUTING.md) 및 [CODE_OF_CONDUCT.md](../../CODE_OF_CONDUCT.md)를 참조하십시오.

## 라이선스
[Apache 2.0](../../LICENSE)

## 문의
질문이나 지원이 필요한 경우 [maintainers](../../MAINTAINERS.md)에게 문의하십시오.
