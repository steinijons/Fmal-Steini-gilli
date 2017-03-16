;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname daemi1) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define (maxElement lis)
  (apply max lis)
)

(define (elementAtIndex lis x)
  (if (eq? x 1)
      (car lis)(elementAtIndex (cdr lis) (- x 1))
  )
)

(define (compress lis)
  (cond
    ((null? lis) '())
    ((null? (cdr lis)) lis)
    ((eq? (car lis) (car (cdr lis))) (compress (cdr lis)))
    (else (cons (car lis) (compress (cdr lis))))
   )
)

(define (maxofmax lis)
  (apply max (map maxElement lis))
)

(define (split lis x)
  (list (firstPart lis x) (secondPart lis x))
)

(define (firstPart lis x)
  (cond
    ((eq? x 0) '())
    (else (cons (car lis) (firstPart (cdr lis) (- x 1))))
    )
  )
  
(define (secondPart lis x)
  (cond
    ((eq? x 0) lis)
    (else (secondPart (cdr lis) (- x 1))))
)
