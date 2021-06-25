job('ejemplo-job-DSL_GitHub') {
  description ('Job creado desde el Seed Job por medio de DSL')
  scm {
    git('https://github.com/aulikes/jenkins.job.parametrizado.git', 'main') { node -> 
      node / gitConfigName('aulikes')
      node / gitConfigEmail('aulikes@hotmail.com')
    }
  }
  parameters {
    stringParam('nombre', defaultValue = 'Mike', description = 'Parámetro de cadena')
    choiceParam('planeta', ['Mercurio', 'Venus', 'Tierra (default)'])
    booleanParam('agente', true)
  }
  triggers {
    cron('H/7 * * * *')
  }
  steps {
    shell("bash jobscript.sh")
  }
  publishers {
    mailer('aulikes@hotmail.com', false, true)
  }
}
