# language: fr
Fonctionnalité: Home Navigation
  Test action on home page
  Plan du Scénario: Clic sur le bouton GoToSearch
    Etant donné que J'ouvre l'application <AppName>
    Lorsque Je clique sur le bouton <Button>
    Alors Search Fragment s'ouvre après <Answer> secondes

    Exemples:
      | AppName       | Button       | Answer |
      | "TmdbAndroid" | "GotoSearch" | 42     |