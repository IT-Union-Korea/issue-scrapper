(ns nodong-scrapper.core
  (:gen-class)
  (:require [net.cgrand.enlive-html :as html]
            [ring.util.codec :as codec])
  (:import (java.nio CharBuffer ByteBuffer)
           (java.nio.charset Charset)
           (java.io InputStreamReader)))

;;byte[] utf8bytes = { (byte)0xc3, (byte)0xa2, 0x61, 0x62, 0x63, 0x64 };
;Charset utf8charset = Charset.forName("UTF-8");
;Charset iso88591charset = Charset.forName("ISO-8859-1");
;
;ByteBuffer inputBuffer = ByteBuffer.wrap(new byte[]{(byte)0xC3, (byte)0xA2});
;
;// decode UTF-8
;CharBuffer data = utf8charset.decode(inputBuffer);
;
;// encode ISO-8559-1
;ByteBuffer outputBuffer = iso88591charset.encode(data);
;byte[] outputData = outputBuffer.array();
;;
(def ^:dynamic *base-url* "http://www.ppomppu.co.kr/zboard/zboard.php?id=freeboard")

(defn fetch-url [url]
  (-> url
      (java.net.URL.)
      (.openStream)
      (InputStreamReader. "EUC-KR")
      (html/html-resource)))

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
    [title href]))

(defn get-ppomppu-contents []
  (map get-title-and-href
       (html/select (fetch-url *base-url*) [:td :a])))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

