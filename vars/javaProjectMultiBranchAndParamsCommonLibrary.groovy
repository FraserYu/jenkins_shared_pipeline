def call(body) {
    // evaluate the body block, and collect configuration into the object
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    
    echo "${pipelineParams.NAME}"
    echo "${pipelineParams.STORY_NAME}"
    echo "${pipelineParams.VERSION}"  

    pipeline {
        agent none

        stages {
            stage('Load Variables') {
                steps {
                    script {
                        pipelineParams.each {
                            k, v -> env."${k}" = "${v}"
                        }
                    }
                }
            }

            stage('Build') {
                steps {
                    echo "${BUILD_STAGE}"
                }  
            }

            stage('Test') {
                steps {
                    echo "${TEST_STAGE}"
                } 
            }

            stage('Deploy') {
                steps {
                    echo "${DEPLOY_STAGE}"
                } 
            }
        }
    }
}