package com.example.composepokedex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.composepokedex.dummies.getOnePokemon
import com.example.composepokedex.dummies.getPokemon
import com.example.composepokedex.dummies.showAllPokemons
import com.example.composepokedex.screens.LoginScreen
import com.example.composepokedex.screens.PokedexMenuScreen
import com.example.composepokedex.screens.PokemonDetailScreen
import com.example.composepokedex.screens.RegisterScreen

@Composable
fun MyApp(){
    val navController = rememberNavController()

    NavHost(navController, startDestination = Login){

        composable<Login> {
            LoginScreen(
                onLoginSuccess = { navController.navigate(PokemonList) },
                onNavigateToRegister = { navController.navigate(Register) }
            )
        }

        composable<Register> {
            RegisterScreen(
                onRegisterSuccess = { navController.navigate(PokemonList) },
                onBackToLogin = { navController.popBackStack() }
            )
        }

        composable<PokemonList>{ PokedexMenuScreen(showAllPokemons(),
            onNavigationDetail = {id -> navController.navigate(route = PokemonDetail(id = id))})
        }

        composable<PokemonDetail> { backStackEntry ->
            val routeData: PokemonDetail = backStackEntry.toRoute()
            val idActual = routeData.id

            val pokemonActual = getPokemon(idActual)
            val previous = if (idActual > 1) {
                try { getPokemon(idActual - 1) } catch (e: Exception) { null }
            } else null

            val next = try { getPokemon(idActual + 1) } catch (e: Exception) { null }

            PokemonDetailScreen(
                pokemon = pokemonActual,
                pokemonNextPrev = Pair(previous, next),
                onNavigate = { id -> navController.navigate(PokemonDetail(id = id)) }
            )
        }
    }
}