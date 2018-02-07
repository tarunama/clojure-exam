(ns exam.router)

;TODO: Remove after create handler
(def router
  ["/" {"articles" {"/" :article-list
                    ["/" [#"\d+" :id]] :article
                    ["/" [#"\d+" :id] "/comments/" [#"\d+" :comment_id]] :comment}}])
