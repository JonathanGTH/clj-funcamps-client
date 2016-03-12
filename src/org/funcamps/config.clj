(ns org.funcamps.confg)

(defonce public-key (or (System/getenv "FUNCAMPS_DOT_COM_PUB")
                        (System/getProperty "funcamps.com-pub-key")))

(defonce secret-key (or (System/getenv "FUNCAMPS_DOT_COM_SEC")
                        (System/getProperty "funcamps.com-sec-key")))

(defonce base-url (or (System/getenv "FUNCAMPS_DOR_COM_URL")
                      (System/getProperty "funcamps.com-url")
                      "https://www.funcamps.com"))
