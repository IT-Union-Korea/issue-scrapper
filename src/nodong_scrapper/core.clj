(ns nodong-scrapper.core
  (:gen-class)
  (:require [nodong-scrapper.ppomppu :refer [뽐뿌-자유게시판-스크랩]]))

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





(defn -main
  "Scrapping ppomppu contents"
  [& args]
  (prn (뽐뿌-자유게시판-스크랩)))

