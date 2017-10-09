node('master') {
    git 'https://github.com/wardviaene/packer-demo'
    
    sh '''cd jenkins-packer-demo
scripts/configure-remote-state.sh <<aws s3 cp s3://terraform-state-madan/state/terraform.tfstate terraform.tfstate>>
aws s3 cp s3://terraform-state-madan8198/amivar.tf amivar.tf
touch mykey
touch mykey.pub
terraform apply -var APP_INSTANCE_COUNT=1 -target aws_instance.app-instance'''
    
    

}
