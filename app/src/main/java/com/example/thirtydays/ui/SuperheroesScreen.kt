package com.example.thirtydays.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.thirtydays.R

private data class Superhero(
    val name: String,
    val identity: String,
    val description: String,
    val power: Int,
    val color: Color,
)

private val Superheroes = listOf(
    Superhero(
        name = "Человек-паук",
        identity = "Питер Паркер",
        description = "Ловкий герой с паутиной и чувством опасности. Совмещает школу и спасение " +
            "Нью-Йорка, а его главная сила — ответственность за тех, кого защищаешь.",
        power = 9,
        color = Color(0xFFD32F2F),
    ),
    Superhero(
        name = "Железный человек",
        identity = "Тони Старк",
        description = "Гений, миллиардер и инженер. Костюм с реактором даёт ему полёт, оружие и " +
            "искусственный интеллект, который помогает принимать решения в бою.",
        power = 8,
        color = Color(0xFFB8860B),
    ),
    Superhero(
        name = "Капитан Америка",
        identity = "Стив Роджерс",
        description = "Символ справедливости и лидер команды. Щит из вибраниума и несгибаемая " +
            "воля делают его надёжным союзником в любой ситуации.",
        power = 8,
        color = Color(0xFF1565C0),
    ),
    Superhero(
        name = "Тор",
        identity = "Тор Одинсон",
        description = "Бог грома из Асгарда. Управляет молнией с помощью молота Мьёльнир и " +
            "обладает силой, которая позволяет ему сражаться с самыми опасными врагами.",
        power = 10,
        color = Color(0xFF6A1B9A),
    ),
    Superhero(
        name = "Чёрная вдова",
        identity = "Наташа Романофф",
        description = "Шпионка и мастер боевых искусств. Её сильные стороны — интеллект, " +
            "хладнокровие и умение находить выход из безвыходных ситуаций.",
        power = 7,
        color = Color(0xFF37474F),
    ),
    Superhero(
        name = "Халк",
        identity = "Брюс Бэннер",
        description = "Учёный, который превращается в зелёного гиганта. Чем сильнее гнев, тем " +
            "больше мощь — но герою важно сохранять контроль над собой.",
        power = 10,
        color = Color(0xFF2E7D32),
    ),
    Superhero(
        name = "Доктор Стрэндж",
        identity = "Стивен Стрэндж",
        description = "Верховный маг, защищающий Землю от мистических угроз. Открывает порталы, " +
            "управляет временем и видит возможные варианты будущего.",
        power = 9,
        color = Color(0xFFEF6C00),
    ),
    Superhero(
        name = "Чёрная пантера",
        identity = "Т'Чалла",
        description = "Король Ваканды и обладатель силы травы-сердца. Костюм из вибраниума " +
            "делает его быстрым и почти неуязвимым, а страна — технологическим лидером.",
        power = 9,
        color = Color(0xFF4527A0),
    ),
)

/**
 * Practice screen from the "Superheroes" codelab: adaptive grid, Material cards,
 * expandable descriptions, animated favourite state and accessible semantics.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperheroesScreen(onBack: () -> Unit) {
    var favorites by rememberSaveable { mutableStateOf(emptySet<String>()) }
    var expandedHero by rememberSaveable { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = stringResource(R.string.superheroes),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = stringResource(R.string.superheroes_subtitle),
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("back_button")) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back),
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                ),
            )
        },
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 300.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                Column(modifier = Modifier.padding(bottom = 4.dp)) {
                    Text(
                        text = stringResource(R.string.heroes_count, Superheroes.size),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.semantics { heading() },
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = stringResource(R.string.heroes_hint),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
            items(items = Superheroes, key = { it.name }) { hero ->
                HeroCard(
                    hero = hero,
                    isFavorite = hero.name in favorites,
                    expanded = expandedHero == hero.name,
                    onToggleExpanded = {
                        expandedHero = if (expandedHero == hero.name) null else hero.name
                    },
                    onToggleFavorite = {
                        favorites = if (hero.name in favorites) {
                            favorites - hero.name
                        } else {
                            favorites + hero.name
                        }
                    },
                )
            }
        }
    }
}

@Composable
private fun HeroCard(
    hero: Superhero,
    isFavorite: Boolean,
    expanded: Boolean,
    onToggleExpanded: () -> Unit,
    onToggleFavorite: () -> Unit,
) {
    val favoriteScale by animateFloatAsState(
        targetValue = if (isFavorite) 1.18f else 1f,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy),
        label = "favourite scale",
    )
    val arrowRotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        label = "hero arrow rotation",
    )
    val cardColor by animateColorAsState(
        targetValue = if (isFavorite) {
            MaterialTheme.colorScheme.secondaryContainer
        } else {
            MaterialTheme.colorScheme.surfaceContainerLow
        },
        label = "hero card colour",
    )

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("hero_card_${hero.name}")
            .clickable(
                onClickLabel = if (expanded) {
                    stringResource(R.string.collapse_tip)
                } else {
                    stringResource(R.string.expand_tip)
                },
                role = Role.Button,
                onClick = onToggleExpanded,
            )
            .animateContentSize(animationSpec = spring(stiffness = Spring.StiffnessMediumLow)),
        colors = CardDefaults.elevatedCardColors(containerColor = cardColor),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                HeroAvatar(hero = hero)
                Spacer(Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = hero.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.semantics { heading() },
                    )
                    Text(
                        text = hero.identity,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
                IconButton(
                    onClick = onToggleFavorite,
                    modifier = Modifier.testTag("favorite_${hero.name}"),
                ) {
                    Icon(
                        imageVector = if (isFavorite) {
                            Icons.Filled.Favorite
                        } else {
                            Icons.Filled.FavoriteBorder
                        },
                        contentDescription = stringResource(
                            if (isFavorite) R.string.favorite_remove else R.string.favorite_add,
                        ),
                        tint = if (isFavorite) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onSurfaceVariant
                        },
                        modifier = Modifier.graphicsLayer {
                            scaleX = favoriteScale
                            scaleY = favoriteScale
                        },
                    )
                }
            }

            Spacer(Modifier.height(12.dp))

            Text(
                text = hero.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = if (expanded) Int.MAX_VALUE else 2,
                overflow = TextOverflow.Ellipsis,
            )

            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut(),
            ) {
                Column {
                    Spacer(Modifier.height(12.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = stringResource(R.string.power),
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier.width(44.dp),
                        )
                        LinearProgressIndicator(
                            progress = { hero.power / 10f },
                            modifier = Modifier
                                .weight(1f)
                                .height(8.dp)
                                .clip(CircleShape),
                            color = hero.color,
                            trackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f),
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = "${hero.power}/10",
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.graphicsLayer { rotationZ = arrowRotation },
                )
            }
        }
    }
}

@Composable
private fun HeroAvatar(hero: Superhero) {
    val initials = hero.name
        .split(' ', '-')
        .filter { it.isNotBlank() }
        .take(2)
        .joinToString("") { it.first().uppercase() }

    Box(
        modifier = Modifier
            .size(56.dp)
            .clip(CircleShape)
            .background(
                Brush.linearGradient(
                    listOf(hero.color, hero.color.copy(alpha = 0.65f)),
                ),
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = initials,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White,
        )
    }
}
