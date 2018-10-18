<nav class="navbar navbar-expand-lg navbar-light bg-light" style="margin-bottom : 50px;">
  <a class="navbar-brand" href="#"> <img src="../img/logo.png" alt="Smiley face" height="42" width="42"></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Accueil <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/tests/show">Mes Tests</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/forward/results">Mes Résultats</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/utilisateur/create">Créer un utilisateur</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/deconnexion">Deconnexion</a>
      </li>
    </ul>
  </div>
</nav>