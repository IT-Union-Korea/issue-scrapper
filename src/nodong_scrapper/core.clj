(ns nodong-scrapper.core
  (:gen-class)
  (:require [nodong-scrapper.ppomppu :refer [뽐뿌-자유게시판-스크랩]]
            [clj-time.core :as t]
            [clj-time.local :as l]
            [clj-time.format :as f]))

(defn 스크랩-내용 []
  {:time (f/unparse (f/formatter (:rfc822 f/formatters)) (l/local-now))
   :ppompu (뽐뿌-자유게시판-스크랩)})


(defn -main
  "Scrapping ppomppu contents"
  [& args]
  (prn (스크랩-내용)))

