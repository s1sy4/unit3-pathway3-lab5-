# Practice: Superheroes app

Codelab: https://developer.android.com/codelabs/basic-android-kotlin-compose-practice-superheroes

Приложение со списком супергероев: карточки с изображением, именем и описанием.

## Что сделано

- Создана модель `Hero` и репозиторий `HeroesRepository` с шестью героями.
- Добавлены строковые ресурсы и векторные изображения героев.
- Настроена тема Material 3: зелёная палитра, шрифт Cabin, скругления 8/16 dp.
- Реализован экран `HeroesList` на `LazyColumn` с карточками:
  изображение 72 dp, имя стилем `displaySmall`, описание — `bodyLarge`.
- Добавлен `CenterAlignedTopAppBar` с названием приложения.
- Включён edge-to-edge режим и согласованный цвет системных панелей.
- Добавлена анимация появления списка и «каскадное» появление карточек
  (`AnimatedVisibility` + `slideInVertically`).
- Подготовлены превью для светлой и тёмной темы.

## Структура

```
app/src/main/java/com/example/superheroes/
├── MainActivity.kt          # каркас экрана и top app bar
├── HeroesScreen.kt          # список и карточка героя
├── model/Hero.kt            # модель
├── model/HeroesDataSource.kt# данные
└── ui/theme/                # Color.kt, Theme.kt, Type.kt, Shape.kt
```

## Запуск

Открыть папку `superheroes` в Android Studio и запустить `app`.

> Итоговый код соответствует официальной ветке `main`
> репозитория basic-android-kotlin-compose-training-superheroes.
