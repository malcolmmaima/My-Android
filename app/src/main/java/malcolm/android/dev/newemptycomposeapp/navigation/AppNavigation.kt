/*
 * Copyright 2025 Malcolm Maima
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package malcolm.android.dev.newemptycomposeapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import malcolm.android.dev.newemptycomposeapp.ui.screens.EmptyScreen
import malcolm.android.dev.newemptycomposeapp.ui.screens.WelcomeScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                onNavigateToEmpty = {
                    navController.navigate(Screen.Empty.route)
                }
            )
        }
        
        composable(Screen.Empty.route) {
            EmptyScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
