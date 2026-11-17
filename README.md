# Simple Animation with Jetpack Compose (Woof)

Codelab: https://developer.android.com/codelabs/basic-android-kotlin-compose-woof-animation

Продолжение приложения **Woof**: в карточках собак появились хобби и плавное раскрытие.

## Что сделано

- Добавлена зависимость `androidx.compose.material:material-icons-extended`.
- Создан composable `DogItemButton()` с `IconButton`; иконка меняется
  с `ExpandMore` на `ExpandLess` в зависимости от состояния.
- В `DogItem()` добавлено состояние `expanded` (`remember { mutableStateOf(false) }`).
- Кнопка выровнена по правому краю с помощью `Spacer(Modifier.weight(1f))`.
- Создан `DogHobby()`: подпись «About» и текст о хобби собаки.
- `DogHobby()` показывается только при `expanded = true`.
- Высота карточки анимируется через `Modifier.animateContentSize()` со
  `spring(dampingRatio = Spring.DampingRatioNoBouncy, stiffness = Spring.StiffnessMedium)`.

## Структура

```
app/src/main/java/com/example/woof/
├── MainActivity.kt        # WoofApp, DogItem, DogItemButton, DogHobby, WoofTopAppBar
├── data/Dog.kt            # модель и список собак (с хобби)
└── ui/theme/              # тема Woof
```

## Запуск

Открыть папку `simple-animation` в Android Studio и запустить `app`.
Проверить анимацию можно в интерактивном режиме `@Preview` или на устройстве.

> Итоговый код соответствует официальной ветке `main`
> репозитория basic-android-kotlin-compose-training-woof.
