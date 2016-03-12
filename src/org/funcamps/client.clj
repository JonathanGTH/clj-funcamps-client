(ns org.funcamps.client
  (:require (org.bovinegenius [exploding-fish :as uri]))
  (:require
   [clojure.string  :as string :refer [join]]
   [org.funcamps.config :as cfg]
   [clj-http.client :as http])
  (:import javax.crypto.spec.SecretKeySpec)
  (:import javax.crypto.Mac)
  (:import org.apache.commons.codec.binary.Base64))

(defn prepare-secret [secret]
  (Base64/decodeBase64 (.getBytes secret)))

(defn hmacSha1
  "get HmacSha1 of phrease using secret.
   Expect secret to be base64 decoding."
  [phrase secret]
  (let [key-spec (SecretKeySpec. secret "HmacSHA1")
        mac (Mac/getInstance "HmacSHA1")
        n(. mac init key-spec)
        sig-bytes (. mac doFinal (.getBytes phrase))
        sig (Base64/encodeBase64URLSafeString sig-bytes)]
    sig))

(defn timestamp []
  (int (* 0.001 (System/currentTimeMillis))))

(defn auth-header
  "create authorzation header for the funcamps.com API reqeust 
   expects secret in base64 encoded format"
  [{:keys [public user timestamp route secret]}]
  (let [secret (prepare-secret secret)
        to-sign (join "|" (filter identity [public user timestamp route]))
        header (join "|" (filter indentity [public user timestamp]))
        signature (hmacSha1 to-sign secret)]
    (println to-sign)
    (str "h=" header"; s=" signature)))
                            
