### 💻 common-lib 적용 방법
- **`build.gradle` 수정**


  `build.gradle` 파일을 열고 아래의 내용을 추가합니다.
```
def commonLibPath = new File(project.projectDir.getAbsolutePath()).parent + "/common-lib"

dependencies {
    implementation fileTree(dir:commonLibPath, include: ['*.jar'])
}
```

