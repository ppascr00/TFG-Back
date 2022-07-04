#!groovy
node {
   try {
      // ------------------------------------
      // -- ETAPA: Compilar y test
      // ------------------------------------
      stage 'Compilar y test'

      // -- Configura variables
      echo 'Configurando variables'
      def mvnHome = tool 'M3'
      env.PATH = "${mvnHome}/bin:${env.PATH}"
      echo "var mvnHome='${mvnHome}'"
      echo "var env.PATH='${env.PATH}'"

      // -- Descarga código desde SCM
      echo 'Descargando código de SCM'
      sh 'rm -rf *'
      checkout scm

      // -- Compilando y test
      echo 'Compilando aplicación'
      sh 'mvn clean test package'

      // ------------------------------------
      // -- ETAPA: SonarQube
      // ------------------------------------
      stage 'SonarQube Analysis'
      echo 'Análisis SonarQube'

      def scannerHome = tool 'SonarQube'
      withSonarQubeEnv('SonarQube'){
         sh "${scannerHome}/bin/sonar-scanner \
         -D sonar.projectKey=TeamFightTacticsSearch \
         -D sonar.host.url=http://localhost:9000/ \
         -D sonar.java.binaries=./target/classes"
      }

      // ------------------------------------
      // -- ETAPA: Deploy war
      // ------------------------------------
      stage 'Deploy'
      deploy adapters: [tomcat9(credentialsId: '5a41b19c-b032-4563-8c2d-0b4d2247ca4b', path: '', url: 'http://localhost:8081')], contextPath: '/teamfighttacticssearch', war: '**/*.war'

      notifySuccessful()

   } catch (e) {
      currentBuild.result = "FAILED"
      notifyFailed()
      throw e
   }
}

def notifySuccessful() {
   emailext (
           subject: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
           body: """<p>SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
        <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
           recipientProviders: [[$class: 'DevelopersRecipientProvider']]
   )
}

def notifyFailed() {
   emailext (
           subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
           body: """<p>FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
        <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>""",
           recipientProviders: [[$class: 'DevelopersRecipientProvider']]
   )
}
