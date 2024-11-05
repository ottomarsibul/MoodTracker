MoodTracker is a minimalist Android app that helps users track their daily mood, energy, stress, confidence, health, and social interactions. 
Users can adjust each of these using scales 1 to 10. Levels on the scales are shown with a different color (red, yellow, green) to reflect low, medium, and high values.
Features:
1. Mood and well-being tracking: Users can input their mood levels by using the scales 1 to 10.
2. Colored feedback: Each level is displayed in a color that reflects the value.
3. Average calculation: The app calculates an average of all six levels and shows it for the user.
4. Minimalist design: The app has a simple, clean design to keep the user experience easy.
Important methods:
1. The onCreate method runs when the app is first opened.
2. The setupScale function addes a "listener" to each SeekBar.
3. The updateSeekbarColor function changes the color of each scale according to the value.
4. When the user presses the submitButton, the app collects the values from all six SeekBars, calculates the average, and displays it in averageTextView.
Future oppurtunities:
1. Daily tracking: Save ratings daily, allowing users to see how their mood and well-being change over time.
2. Data analysis: Analyze collected data to help users identify trends and patterns in their well-being.
3. Suggestions: Provide advice or tips based on mood patterns to help improve well-being.
4. Send data to others: Add an option to share mood data with friends or family members, like parents or a close friend.
