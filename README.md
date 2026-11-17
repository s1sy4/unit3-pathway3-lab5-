# Material Theming with Jetpack Compose (Woof)

Codelab: https://developer.android.com/codelabs/basic-android-kotlin-compose-material-theming

Приложение **Woof** — список собак с фотографиями, именами и возрастом. В этом задании
приложение оформлено по правилам Material Design.

## Что сделано

- Создана собственная цветовая схема Material 3 для светлой и тёмной темы
  (`ui/theme/Color.kt`, `ui/theme/Theme.kt`).
- Реализована `WoofTheme()` с поддержкой `darkTheme` и (опционально) dynamic color.
- Настроен edge-to-edge режим: прозрачные системные панели и правильный цвет иконок.
- Настроены формы: аватар собаки — круг, карточка списка — скругление 16 dp с двух углов
  (`ui/theme/Shape.kt`).
- Подключены шрифты Abril Fatface и Montserrat, настроены стили
  `displayLarge`, `displayMedium`, `labelSmall`, `bodyLarge` (`ui/theme/Type.kt`).
- Элемент списка обёрнут в `Card`, добавлены отступы из `dimens.xml`.
- Добавлен `CenterAlignedTopAppBar` с логотипом и названием приложения.
- Добавлен `@Preview` для тёмной темы.

## Структура

```
app/src/main/java/com/example/woof/
├── MainActivity.kt        # список, карточка собаки, top app bar, превью
├── data/Dog.kt            # модель и список собак
└── ui/theme/              # Color.kt, Theme.kt, Shape.kt, Type.kt
```

## Запуск

Открыть папку `material-theming` в Android Studio и запустить конфигурацию `app`.
Минимальная версия Android — 24.

> Исходная точка: официальная ветка `material` репозитория
> google-developer-training/basic-android-kotlin-compose-training-woof.
