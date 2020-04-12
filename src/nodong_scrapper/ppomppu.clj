(ns nodong-scrapper.ppomppu
  (:require [net.cgrand.enlive-html :as html]
            [nodong-scrapper.util :refer [euc-kr-url-reader]]))

(def ^:dynamic *base-url* "http://www.ppomppu.co.kr/zboard/zboard.php?id=freeboard")
(def ^:dynamic *state-url* "http://www.ppomppu.co.kr/zboard/")


(defn 자유게시판-주소
  [페이지-번호]
  (str "http://www.ppomppu.co.kr/zboard/zboard.php?id=freeboard&page=" 페이지-번호))

(defn get-title-and-href [selected]
  (let [title
        (some-> selected
                (:content)
                (first)
                (:content)
                (first))
        href (some-> selected
                     (:attrs)
                     (:href))]
    [title (str *state-url* href)]))

(def 키워드 #"해고|실업|급여반납|무급휴가")

(defn contains-keyword? [title]
  (when (string? title)
    (re-find 키워드 title)))

(defn get-ppomppu-contents [페이지-번호]
  (dosync (filter #(contains-keyword? (first %))
                  (map get-title-and-href
                       (html/select
                         (euc-kr-url-reader (자유게시판-주소 페이지-번호)) [:td :a])))))

(defn 뽐뿌-자유게시판-스크랩 []
  (flatten (map get-ppomppu-contents (range 1 200))))

