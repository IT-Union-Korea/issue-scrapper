(ns nodong-scrapper.ppomppu
  (:require [net.cgrand.enlive-html :as html]
            [nodong-scrapper.util :refer [euc-kr-url-reader]]))

(def ^:dynamic *base-url* "http://www.ppomppu.co.kr/zboard/zboard.php?id=freeboard")
(def ^:dynamic *state-url* "http://www.ppomppu.co.kr/zboard/")


(defn 자유게시판-주소
  [페이지-번호]
  (str "http://www.ppomppu.co.kr/zboard/zboard.php?id=freeboard&page=" 페이지-번호))

(defn row->title [row]
  (some-> row
          (:content)
          (first)
          (:content)
          (first)))

(defn row->href [row]
  (some-> row
          (:attrs)
          (:href)))

(defn get-title-and-href [row]
  [(row->title row) (str *state-url* (row->href row))])

(def 키워드 #"사장|퇴직|노동|해고|실업|급여반납|무급휴가")

(defn contains-keyword? [title]
  (when (string? title)
    (re-find 키워드 title)))

(defn ppomppu-contents [페이지-번호]
  (-> (자유게시판-주소 페이지-번호)
      (euc-kr-url-reader)
      (html/select [:td :a])))

(defn filter-by-keyword [contents]
  (->> contents
       (map get-title-and-href)
       (filter #(contains-keyword? (first %)))))

(defn retreive-ppomppu-contents [페이지-번호]
  (filter-by-keyword (ppomppu-contents 페이지-번호)))

(defn 뽐뿌-자유게시판-스크랩 []
  (->> (range 1 200)
       (map retreive-ppomppu-contents)
       (filter (comp not empty?))
       (reduce into)))
