#!groovy

node {
   // ------------------------------------
   // -- ETAPA: Compilar
   // ------------------------------------
   stage 'Compilar'

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

   // -- Compilando
   echo 'Compilando aplicación'
   sh 'mvn clean test package'

   // ------------------------------------
   // -- ETAPA: Test
   // ------------------------------------
   //stage 'Test'
   //echo 'Ejecutando tests'
   //try{
      //sh 'mvn verify'
      //step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
   //}catch(err) {
      //step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
      //if (currentBuild.result == 'UNSTABLE')
         //currentBuild.result = 'FAILURE'
         //throw err
   //}


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
   // -- ETAPA: Instalar
   // ------------------------------------
   //stage 'Instalar'
   //echo 'Instala el paquete generado en el repositorio maven'
   //sh 'mvn install -Dmaven.test.skip=true'

   // ------------------------------------
   // -- ETAPA: Archivar
   // ------------------------------------
   //stage 'Archivar'
   //echo 'Archiva el paquete el paquete generado en Jenkins'
   //step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar, **/target/*.war', fingerprint: true])

   // ------------------------------------
   // -- ETAPA: Deploy war
   // ------------------------------------
   stage 'Deploy'
   deploy adapters: [tomcat9(credentialsId: '5a41b19c-b032-4563-8c2d-0b4d2247ca4b', path: '', url: 'http://localhost:8081')], contextPath: '/', war: '**/*.war'

   /*post {
      always {
         sh 'cp target/teamfighttacticssearch.war TOMCAT_DIRECTORY/webapps/'
      }
      failure {
         mail subject: 'The Pipeline failed', to: 'perico10fiera@gmail.com'
      }
   }*/


}
