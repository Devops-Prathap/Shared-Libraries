def call(ip,user,credId){
     sshagent(credentials: ['aws-tomcat-creds'], executable: '') {
                 // rename war file
                 sh "mv target/myweb-*.war target/app.war"
                 // copy war file
                 sh "scp -o StrictHostKeyChecking=no target/app.war ${user}@${ip}:/opt/tomcat9/webapps"
                 // stop tomcat
                 sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
                 // start tomcat
                 sh "ssh ${user}@{ip} /opt/tomcat9/bin/startup.sh"
     }
}
