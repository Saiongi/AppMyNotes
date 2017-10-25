# AppMyNotes
Application for notes

Как развернуть проект

1. Запустить базу MySQL на порту 3306 с названием test, пользователем root и паролем root
2. Запустить сервер Tomcat по адресу http://localhost:8080/todo/ (просто скопировать Сервер/todo.war в директорию webappps)
3. Разместить на веб-сервере клиентскую часть (например, OpenServer) - скопировать содержимое каталога Клиент/dist в папку-домен

Используемые технологии

1. Сервер: Spring MVC REST Web Services CRUD with Hibernate (Maven, Tomcat)
2. Клиент: Angular 4 with TypeScript

Функционал

1. Добавление новых заметок
2. Удаление заметок
3. Изменение статуса заметки на выполнено или невыполнено
4. Фильтрация по типу статуса заметки: все, выполненные или невыполненные
5. Фильтрация по дате добавления в обе стороны
6. Постраничная пагинация с возможностью выбора количества записей на странице
7. Фильтры статуса, даты и пагинация умеют работать в команде)
