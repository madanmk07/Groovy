node('master') {
    
    stage('SCM') {
    
    git 'https://github.com/madanmk07/packer-demo.git'
    }

    stage('Shell execution') {
    
    sh '''ARTIFACT=`packer build -machine-readable packer-demo.json | awk -F, \'$0 ~/artifact,0,id/ {print $6}\'`
AMI_ID=`echo $ARTIFACT |cut -d \':\' -f2`
echo \'variable "APP_INSTANCE_AMI" { default = "\'${AMI_ID}\'" }\' > amivar.tf

aws s3 cp amivar.tf s3://terraform-state-madanmk07/amivar.tf'''
}
}
