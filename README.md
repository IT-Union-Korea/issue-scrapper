# nodong-scrapper

노동관련 이슈를 스크래핑합니다.

## Installation

다운로드 링크 : https://github.com/jocatelo/nodong-scrapper.git


## Usage

빌드 준비사항 : Java 1.8 이상, Leiningen(https://leiningen.org/#install), Clojure(https://clojure.org/guides/getting_started)

빌드 및 실행 방법 :

```
$ git clone https://github.com/jocatelo/nodong-scrapper.git
$ lein run
```

또는

```
$ lein jar
$ java -jar {빌드된 경로}/nodong-scrapper-0.1.0-standalone.jar
```


FIXME: listing of options this app accepts.

## Examples

```
$ lein run
("회사가 어려워서 희망퇴직 할 경우 실업급여 받을 수 있나요?" "http://www.ppomppu.co.kr/zboard/view.php?id=freeboard&page=37& "3월 취업자 19.5만명 줄어 11년만에 최악…체감실업률 '역대최고'" "http://www.ppomppu.co.kr/zboard/view.php?id=freeboard&page=8088" "CGV, 직영 극장 임대료도 못냈다…급여반납·희망퇴직 단행" "http://www.ppomppu.co.kr/zboard/view.php?id=freeboard&page=81735" "미통당 대표 이번엔 문자해고 받기전 빤스런" "http://www.ppomppu.co.kr/zboard/view.php?id=freeboard&page=179&divpage=1297&no=6953450")
```

## Options
### Bugs
### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2020 IT Union
