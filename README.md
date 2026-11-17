# Project: 30 Days App — «30 дней Android»

Codelab: https://developer.android.com/codelabs/basic-android-kotlin-compose-30-days

Итоговый проект Unit 3: приложение с 30 советами по Android-разработке на Compose —
по одному на каждый день месяца. У каждого совета есть заголовок, категория,
текст и тематическая иллюстрация.

## Возможности

- Прокручиваемый список из 30 карточек (`LazyColumn`, стабильные ключи по номеру дня).
- Своя тема Material 3: 4 акцентные палитры, переключаются в диалоге настроек;
  поддержка светлой и тёмной темы; кастомный вариативный шрифт Manrope;
  собственные формы и типографика.
- Прогресс прохождения: `LinearProgressIndicator` с анимацией, счётчик и процент.
- Карточка раскрывается по нажатию (`animateContentSize`, `AnimatedVisibility`),
  стрелка поворачивается, цвет карточки и бейджа анимируется при выполнении дня.
- Кнопка «Случайный совет» прокручивает список к случайному невыполненному дню.
- Выполненные дни сохраняются при повороте экрана (`rememberSaveable` + `listSaver`).
- Анимационный переход между экранами (`AnimatedContent`).
- Дополнительный экран «Супергерои» — практика из этого же pathway: сетка карточек,
  избранное, раскрывающиеся описания, анимации, семантика для TalkBack.
- Доступность: contentDescription у иконочных кнопок, декоративные изображения
  с `null`, размеры целей касания не меньше 48 dp, `stateDescription` у действий,
  заголовки размечены через `heading()`, тексты в `strings.xml`.
- UI-тесты доступности (`app/src/androidTest/.../AccessibilityTest.kt`).

## Структура

```
app/src/main/java/com/example/thirtydays/
├── MainActivity.kt
├── data/Tip.kt, data/TipsRepository.kt   # 30 советов
├── ui/ThirtyDaysApp.kt                   # состояние и переход между экранами
├── ui/TipsScreen.kt                      # список, прогресс, выбор темы, FAB
├── ui/TipCard.kt                         # раскрывающаяся карточка
├── ui/SuperheroesScreen.kt               # практика Superheroes
└── ui/theme/                             # Color.kt, Theme.kt, Type.kt
```

## Запуск и проверка

1. Открыть папку `thirty-days` в Android Studio.
2. Запустить конфигурацию `app` (minSdk 24).
3. UI-тесты: `./gradlew connectedDebugAndroidTest` на подключённом устройстве/эмуляторе.

> Проект использует AGP 9.4.1, Kotlin 2.2.10 и Compose BOM 2026.02.01.
