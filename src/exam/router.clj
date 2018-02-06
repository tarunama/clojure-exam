(ns exam.router)

(def router
  ["/" {"articles" {"/" :article-list
                    ["/" [#"\d+" :id]] :article
                    ["/" [#"\d+" :id] "/comments/" [#"\d+" :comment_id]] :comment}}])
