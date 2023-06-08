Задание MVC.
1) Изучить структуру MVC.
   https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#spring-web
   https://www.baeldung.com/spring-mvc-tutorial
   https://spring.io/guides/gs/serving-web-content/
   http://spring-projects.ru/projects/spring-framework/
   https://habr.com/ru/articles/500572/
2) Посмотреть ключевые аннотации:
   @Controller
   @RequestMapping
   @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping
   @PathVariable, @RequestParam
3) Почитать про thymeleaf
4) Написать простейшее приложение, у которого есть два урла.
   Первый это /hello?count={num}
   Выводится то количество раз Hello world, какое количество num.
   Например:
   /hello?count=3 - должно быть выведено три раза Hello world. Если count  не указано, то по дефолту выводиться 1 раз.
   /user
   Второй это /users?name={name}&surname={surname}
   На страничке должно отображаться:
   Привет, {name} {surname}!