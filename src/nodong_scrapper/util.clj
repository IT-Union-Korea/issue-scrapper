(ns nodong-scrapper.util
  (:require [net.cgrand.enlive-html :as html])
  (:import (java.net URL)
           (java.io InputStreamReader)))

(defn euc-kr-url-reader [url]
  (dosync (-> url
              (URL.)
              (.openStream)
              (InputStreamReader. "EUC-KR")
              (html/html-resource))))